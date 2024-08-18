package com.example.econnect;

import com.example.econnect.models.District;
import com.example.econnect.models.Region;
import com.example.econnect.models.Ward;
import com.example.econnect.repositories.DistrictRepository;
import com.example.econnect.repositories.RegionRepository;
import com.example.econnect.repositories.WardRepository;
import org.json.JSONArray;
import org.springframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

@Slf4j
@Component
public class LocationSeeder implements CommandLineRunner {
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    WardRepository wardRepository;

    @Value("classpath:Regions.json")
    private Resource regionResource;
    @Value("classpath:Districts.json")
    private Resource districtResource;
    @Value("classpath:Wards.json")
    private Resource wardsResource;

    @Override
    public void run(String... args) throws Exception {
        //loadLocations();
        //loadDistricts();
        //loadWards();
    }

    private void loadLocations() {
        JSONObject jsonObject = new JSONObject(readJsonFile(regionResource));
        JSONArray jsonArray = jsonObject.getJSONArray("features");

        for (int i = 0; i < jsonArray.length(); i++) {
            String regionName = jsonArray.getJSONObject(i).getJSONObject("properties").getString("region");
            Region region = regionRepository.findByName(regionName);

            if (region == null) {
                Region newRegion = new Region();
                newRegion.setName(regionName);
                regionRepository.save(newRegion);
            }
        }
    }

    private void loadDistricts() {
        JSONObject jsonObject = new JSONObject(readJsonFile(districtResource));
        JSONArray jsonArray = jsonObject.getJSONArray("features");

        for (int i = 0; i < jsonArray.length(); i++) {
            String districtName = jsonArray.getJSONObject(i).getJSONObject("properties").getString("District");
            String regionName = jsonArray.getJSONObject(i).getJSONObject("properties").getString("region").replace(" Region","");
            Region region = regionRepository.findByName(regionName);

            if (region == null) {
                log.info("THIS REGION IS MISSING: {}", regionName);
                continue;
            }

            District district = districtRepository.findByName(districtName);
            if (district == null) {
                District newDistrict = new District();
                newDistrict.setName(districtName);
                newDistrict.setRegionId(region.getId());
                districtRepository.save(newDistrict);
            }
        }
    }

    private void loadWards() {
        JSONObject jsonObject = new JSONObject(readJsonFile(wardsResource));
        JSONArray jsonArray = jsonObject.getJSONArray("features");

        for (int i = 0; i < jsonArray.length(); i++) {
            String districtName = jsonArray.getJSONObject(i).getJSONObject("properties").getString("District");
            String wardName = jsonArray.getJSONObject(i).getJSONObject("properties").getString("Ward");
            log.info("wardName: {} ,DistrictName: {}", wardName, districtName);
            District district = districtRepository.findByName(districtName);
            if (district == null) {
                log.info("THIS DISTRICT IS MISSING: {}", districtName);
                continue;
            }

            Ward ward = wardRepository.findByName(wardName);
            if (ward == null) {
                Ward newWard = new Ward();
                newWard.setName(wardName);
                newWard.setDistrictId(district.getId());
                wardRepository.save(newWard);
            }
        }
    }

    public String readJsonFile(Resource resource) {
        try {
            InputStream inputStream = resource.getInputStream();
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.zoostore.persistence.entities;

import com.example.zoostore.persistence.repositories.MultimediaRepository;
import com.example.zoostore.persistence.repositories.TagRepository;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDataBase implements CommandLineRunner {
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;

    private final MultimediaRepository multimediaRepository;
    @Override
    public void run(String... args) throws Exception {

    this.InitTags();
    this.InitVendor();
    this.InitMultiMedia();

    }
     private void InitMultiMedia(){
        if(multimediaRepository.count()>0){
            return;
        }
        Multimedia multimedia=Multimedia.builder().url("neshto1").build();
         Multimedia multimedia1=Multimedia.builder().url("neshto2").build();
         multimediaRepository.save(multimedia);
         multimediaRepository.save(multimedia1);
     }

    private void InitTags(){
        if(tagRepository.count()>0){
            return;
        }
        Tag tag=Tag.builder().name("Food").build();
        Tag tag1=Tag.builder().name("Neshto").build();
        tagRepository.save(tag1);
        tagRepository.save(tag);
    }

    private void InitVendor(){
        if(vendorRepository.count()>0){
            return;
        }
        Vendor vendor= Vendor.builder().name("Whiskas").build();
        vendorRepository.save(vendor);
    }

}

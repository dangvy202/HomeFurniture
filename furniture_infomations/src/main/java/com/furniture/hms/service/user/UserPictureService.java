package com.furniture.hms.service.user;

import com.furniture.hms.enums.ImageEnum;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class UserPictureService {

    public String savePicture(String path,String picture,byte[] pictureByte) {
        //save image into folder
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File(path,picture)
                    )
            );
            outputStream.write(pictureByte);
            outputStream.flush();
            outputStream.close();
            //end save image into folder
            return ImageEnum.SUCCESS.getValue();
        } catch (Exception ex){
            return ImageEnum.FAIL_EXTENSION.getValue();
        }
    }
}

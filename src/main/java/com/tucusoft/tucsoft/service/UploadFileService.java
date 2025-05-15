package com.tucusoft.tucsoft.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

    private String folder = "images/7";

    public String saveImage(MultipartFile file) {
        if (!file.isEmpty()) {
            // redirectAttributes.addFlashAttribute("mensaje", "Por favor selecciona un
            // archivo.");
            // return "redirect:/upload";
            try {
                // Aquí puedes guardar el archivo en el sistema o procesarlo
                String nombreArchivo = file.getOriginalFilename();
                byte[] bytes = file.getBytes();

                // Por ejemplo, guardarlo en una carpeta temporal
                Path ruta = Paths.get(folder + nombreArchivo);
                Files.write(ruta, bytes);
                return nombreArchivo;

                // redirectAttributes.addFlashAttribute("mensaje", "Archivo subido exitosamente:
                // " + nombreArchivo);
            } catch (IOException e) {
                // redirectAttributes.addFlashAttribute("mensaje", "Error al subir el
                // archivo.");
                e.printStackTrace();
            }
        }
        return "default.jpg";

    }

    public void deleteImage(String nombre) {
        if (!nombre.equals("default.jpg")) {
            File file = new File(folder + nombre);
            file.delete();
        }

    }

}

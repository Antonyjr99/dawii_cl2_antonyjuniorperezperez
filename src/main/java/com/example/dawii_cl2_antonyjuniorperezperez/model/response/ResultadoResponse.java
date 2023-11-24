package com.example.dawii_cl2_antonyjuniorperezperez.model.response;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}

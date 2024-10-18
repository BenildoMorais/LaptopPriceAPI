package com.exercicos.benildo.laptoppriceapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;

@Controller
public class PredictController {

    @PostMapping("/PredictLab")
    @CrossOrigin
    public ResponseEntity<String> preverPreco(@ModelAttribute LaptopCaracteristicas caracteristicas) throws Exception {


        LinearRegression loadedModel = PredictPrice.loadModel("modelo.model");

            Instance novaInstancia = LoadDataset.CriarInstance(caracteristicas);

            double predictedPrice = PredictPrice.predict(loadedModel, novaInstancia);

            String resultado = String.format("%.2f", predictedPrice);

        return ResponseEntity.ok().body("Valor Maximo Recomendado: " + resultado +"Mt");
    }

}

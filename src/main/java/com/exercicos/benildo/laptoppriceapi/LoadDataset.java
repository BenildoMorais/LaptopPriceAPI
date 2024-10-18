package com.exercicos.benildo.laptoppriceapi;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;

public class LoadDataset {
    public static Instances loadDataset(String datasetPath) throws Exception {
        DataSource source = new DataSource(datasetPath);
        Instances dataset = source.getDataSet();

        if (dataset.classIndex() == -1) {
            dataset.setClassIndex(dataset.numAttributes() - 1);
        }
        return dataset;
    }

    public static Instance CriarInstance(LaptopCaracteristicas caracteristicas) {

        ArrayList<Attribute> atributos = new ArrayList<>();

        atributos.add(new Attribute("Company", (ArrayList<String>) null));
        atributos.add(new Attribute("Product", (ArrayList<String>) null));
        atributos.add(new Attribute("Inches"));
        atributos.add(new Attribute("ScreenResolution", (ArrayList<String>) null));
        atributos.add(new Attribute("Cpu", (ArrayList<String>) null));
        atributos.add(new Attribute("Ram", (ArrayList<String>) null));
        atributos.add(new Attribute("Memory", (ArrayList<String>) null));
        atributos.add(new Attribute("Gpu", (ArrayList<String>) null));
        atributos.add(new Attribute("Price_metical"));

        Instances dataset = new Instances("LaptopDataset", atributos, 0);

        Instance novaInstancia = new DenseInstance(9);
        novaInstancia.setDataset(dataset);
        novaInstancia.setValue(atributos.get(0), caracteristicas.getMarca());
        novaInstancia.setValue(atributos.get(1), caracteristicas.getModelo());
        novaInstancia.setValue(atributos.get(2), Double.valueOf(caracteristicas.getTamanhoTela()));
        novaInstancia.setValue(atributos.get(3), caracteristicas.getTipoTela());
        novaInstancia.setValue(atributos.get(4), caracteristicas.getProcessador());
        novaInstancia.setValue(atributos.get(5), caracteristicas.getMemoriaRam());
        novaInstancia.setValue(atributos.get(6), caracteristicas.getArmazenamento());
        novaInstancia.setValue(atributos.get(7), caracteristicas.getPlacaGrafica());
        novaInstancia.setValue(atributos.get(8), 0);

        dataset.add(novaInstancia);

        return novaInstancia;
    }

}


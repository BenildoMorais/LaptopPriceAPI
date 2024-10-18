package com.exercicos.benildo.laptoppriceapi;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.SerializationHelper;

public class PredictPrice {
    public static double predict(LinearRegression model, Instance instance) throws Exception {
        return model.classifyInstance(instance);
    }

    public static LinearRegression loadModel(String modelPath) throws Exception {
        return (LinearRegression) SerializationHelper.read(modelPath);
    }
}


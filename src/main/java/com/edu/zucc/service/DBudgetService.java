package com.edu.zucc.service;

import com.edu.zucc.mapper.DBudgetMapper;
import com.edu.zucc.model.DBudget_Theta;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.DBudget;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBudgetService {
    private DBudgetMapper dBudgetMapper;

    @Autowired
    public DBudgetService(DBudgetMapper dBudgetMapper) {
        this.dBudgetMapper = dBudgetMapper;
    }

    public EButil add(DBudget dBudget) {
        EButil result = new EButil();
        dBudgetMapper.add(dBudget);
        result.Success();
        return result;
    }

    public EButil delete(DBudget dBudget) {
        EButil result = new EButil();
        if (findById(dBudget.getId()) == null) {
            result.Error("Messageboard is not existed");
            return result;
        }
        dBudgetMapper.delete(dBudget);
        result.Success();
        return result;
    }

    public EButil update(DBudget dBudget) {
        EButil result = new EButil();
        if (findById(dBudget.getId()) == null) {
            result.Error("DBudget is not existed");
            return result;
        }
        dBudgetMapper.update(dBudget);
        result.Success();
        return result;
    }

    public List<DBudget> findAll() {
        return dBudgetMapper.findAll();
    }

    public DBudget findById(int id) {
        DBudget dBudget = new DBudget();
        dBudget.setId(id);
        return dBudgetMapper.findByKey(dBudget);
    }

    public void setTheta() {
        List<DBudget> dBudgets = dBudgetMapper.findByCity();
        int row = dBudgets.size();
        double[][] x = new double[row][5];
        double[] y1 = new double[row];
        double[] y2 = new double[row];
        double[] y3 = new double[row];
        double[] y4 = new double[row];
        for (DBudget dBudget : dBudgets) {
            x[row - 1][0] = dBudget.getHarea();
            x[row - 1][1] = dBudget.getRoom();
            x[row - 1][2] = dBudget.getHall();
            x[row - 1][3] = dBudget.getToilet();
            x[row - 1][4] = dBudget.getBalcony();
            y1[row - 1] = dBudget.getMatfee();
            y2[row - 1] = dBudget.getLabfee();
            y3[row - 1] = dBudget.getDesfee();
            y4[row - 1] = dBudget.getQuafee();
            row--;
        }
        OLSMultipleLinearRegression r1 = new OLSMultipleLinearRegression();
        OLSMultipleLinearRegression r2 = new OLSMultipleLinearRegression();
        OLSMultipleLinearRegression r3 = new OLSMultipleLinearRegression();
        OLSMultipleLinearRegression r4 = new OLSMultipleLinearRegression();
        r1.newSampleData(y1, x);
        r2.newSampleData(y2, x);
        r3.newSampleData(y3, x);
        r4.newSampleData(y4, x);
        DBudget_Theta theta = new DBudget_Theta();
        double data[]=r1.estimateRegressionParameters();
        theta.setA1(r1.estimateRegressionParameters());
        theta.setA2(r2.estimateRegressionParameters());
        theta.setA3(r3.estimateRegressionParameters());
        theta.setA4(r4.estimateRegressionParameters());
    }

    public double[] getFee(int city, int htype, double harea, int room, int hall, int kitchen, int toilet, int balcony) {
        double[] fee = new double[4];
        double crete = 1;
        double trete = 1;
        if (city==3) crete = 1.106060606060606;
        if (htype == 2) trete = 1.18517316017316;
        double[] a1 = DBudget_Theta.getA1();
        double[] a2 = DBudget_Theta.getA2();
        double[] a3 = DBudget_Theta.getA3();
        double[] a4 = DBudget_Theta.getA4();
        double mfee = a1[0] * 1 +a1[1] * harea + a1[2] * room + a1[3] * hall + a1[4] * toilet + a1[5] * balcony;
        double lfee = a2[0] * 1 +a2[1] * harea + a2[2] * room + a2[3] * hall + a2[4] * toilet + a2[5] * balcony;
        double dfee = a3[0] * 1 +a3[1] * harea + a3[2] * room + a3[3] * hall + a3[4] * toilet + a3[5] * balcony;
        double qfee = a4[0] * 1 +a4[1] * harea + a4[2] * room + a4[3] * hall + a4[4] * toilet + a4[5] * balcony;
        fee[0] = Math.round(mfee * crete);
        fee[1] = Math.round(lfee * crete * trete);
        fee[2] = Math.round(dfee * crete);
        fee[3] = Math.round(qfee);
        return fee;
    }
}

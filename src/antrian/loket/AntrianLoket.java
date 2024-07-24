/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.loket;

/**
 *
 * @author RSUD
 */
public class AntrianLoket {

    private static int nomorAntrian = 1;

    public static String ambilNomorAntrian() {
        return String.format("%02d", nomorAntrian++);
    }
    
}

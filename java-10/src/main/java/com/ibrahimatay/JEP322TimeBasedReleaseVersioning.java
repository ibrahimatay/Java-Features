package com.ibrahimatay;

public class JEP322TimeBasedReleaseVersioning {
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();
        version.feature();
        version.interim();
        version.update();
        version.patch();
        System.out.println("Feature:"+version.feature()+"  Interim:"+version.interim()+" Update:"+version.update()+" Patch:"+ version.patch());
        // Feature:18  Interim:0 Update:2 Patch:1
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atena;

import SecuGen.FDxSDKPro.jni.*;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author svt
 */
public class Atena {

    static long deviceName = SGFDxDeviceName.SG_DEV_FDU03;
    static long devicePort = 0;
    static JSGFPLib fplib = null;
    static long ret;
    static private SGDeviceInfoParam deviceInfo = new SGDeviceInfoParam();
    static String mensaje = "";
    static boolean lectorInit =false; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Init del lector
        fplib = new JSGFPLib();
        ret = fplib.Init(deviceName);
        if ((fplib != null) && (ret == SGFDxErrorCode.SGFDX_ERROR_NONE)) {

            devicePort = SGPPPortAddr.AUTO_DETECT;

            ret = fplib.OpenDevice(devicePort);
            if (ret == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                ret = fplib.GetDeviceInfo(deviceInfo);
                if (ret == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                    mensaje="Dispositivo inicializado con exito";
                    //todo enable controls
                    lectorInit=true;
                } else {
                    mensaje = "GetDeviceInfo() Error [" + ret + "]";
                }
            } else {
                mensaje ="OpenDevice() Error [" + ret + "]";
            }
        } else {
           mensaje ="JSGFPLib Initialization Failed";
        }

        //fin init
        // TODO code application logic here
        Inicio inicio = new Inicio();
        inicio.setLocation(200, 150);
        inicio.setResizable(false);
        inicio.getContentPane().setBackground(new Color(192, 222, 237));
        inicio.setMensaje(mensaje);
        inicio.setValidacion(lectorInit);
        inicio.setFplib(fplib);
        inicio.setDeviveInfo(deviceInfo);
        inicio.validate();
        inicio.setVisible(true);
        
        

    }

}

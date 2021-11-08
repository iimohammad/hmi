
package main.serial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.fazecast.jSerialComm.*;
import java.io.IOException;


 
public class SerialController implements Initializable {
    
    public static SerialPort firstAllAvailblePort;
    
    
    @FXML
    private TextArea textField;
    @FXML
    private Button sendBtn;
    @FXML
    private Button receive_btn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    private uartClass uart1 = new uartClass();
    
    @FXML
    private void handlBtn(ActionEvent event) throws IOException,InterruptedException {
         textField.setText(uart1.ListPorts());
//         textField.setText("hi");
         uart1.SelectPort(1);
         uart1.starter();
         uart1.sendUartPacket();
//         textField.setText(uart1.sendUartPacket());
         
//        textField.setText();
//        SerialPort.getCommPorts();
//            textField.setText("jo");
//          SerialPort[] allAvailbleComports = SerialPort.getCommPorts();
//          for (SerialPort eachAvailbleCommport:allAvailbleComports){
//                 textField.setText("List"+eachAvailbleCommport.getDescriptivePortName());
//                 
//          }
//          firstAllAvailblePort = allAvailbleComports[0];
//          firstAllAvailblePort.openPort();
//          textField.appendText("\n Open"+firstAllAvailblePort.getDescriptivePortName());
//          InputStream comPortInput = firstAllAvailblePort.getInputStream();
//          OutputStream comPortoutput = firstAllAvailblePort.getOutputStream();
//          comPortInput.skip(comPortInput.available());
//          
//          int readOneByteASCII;
//          do{
//              readOneByteASCII = comPortInput.read();
//          }while(readOneByteASCII !=10);
    }
    


    
    
    @FXML
    private void handleReceive(ActionEvent event) throws IOException,InterruptedException {
//        textField.setText(uart1.ListPorts());
//        uart1.SelectPort(1);
//        uart1.starter(); 
        uart1.ReceivePacket();
//        textField.setText(uart1.getCommand());
    }
    
    public void setText(String text){
        textField.setText(text);
    }
 
    
}

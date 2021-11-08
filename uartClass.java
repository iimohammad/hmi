//
//package main.serial;
//
//import com.fazecast.jSerialComm.*;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class uartClass {
//    
//    private int portNumber = 0;
//    public static SerialPort SelectedPort;
//    SerialPort[] allAvailbleComports ;
//    
//    public void initialize(){
//        allAvailbleComports = SerialPort.getCommPorts();
//    }
//    
//    public String FindAllAvailableCommPorts(){
//        String result = "";
//        initialize();
//        for (SerialPort eachAvailbleCommport:allAvailbleComports){
//                  result = result+"List:"+eachAvailbleCommport.getDescriptivePortName();         
//          }
//        return result;
//    }
//    public void selectPort(int port){
//        portNumber = port;
//    }
//    public boolean openPort(){
//        SelectedPort = allAvailbleComports[portNumber];
//        boolean openPort = SelectedPort.openPort();
//        return openPort;
//    }
//    void SelectedPortInfo(){
//        
//    }
//}



package main.serial;

import com.fazecast.jSerialComm.*;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class uartClass {
    
    public static SerialPort SelectedPort;
    private SerialPort[] allAvailableComports;
    private String AvailblePorts = "";
    private String LogOutputData = "";
    InputStream is ;
    OutputStream os ;
    StringBuffer cmd = new StringBuffer();
    int c = 0;
    private boolean successfull = false;
    //some ascii values for for certain things
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;
    
     //the timeout value for connecting with the port
    final static int TIMEOUT = 2000;
    
    
//    for (SerialPort eachAvailableCommport :allAvailableComports)static {
        public void getAllPorts(){
            allAvailableComports = SerialPort.getCommPorts();
        }
        public String ListPorts() throws IOException {
            getAllPorts();
            for (SerialPort eachAvailableCommport :allAvailableComports){
                   AvailblePorts =AvailblePorts + "List:  "+eachAvailableCommport.getDescriptivePortName() ;
            }
            return AvailblePorts;
        }
        public void SelectPort(int num){
            SelectedPort=allAvailableComports[num];
        }
        public void OpenPortFunc(){
            SelectedPort.openPort();
         
        }
        public String openPortInfo(){
            return SelectedPort.getDescriptivePortName();
        }
        public void ClosePortFucn(){
            SelectedPort.closePort();
        }
        public String PortInfo(){
            String portInfo = SelectedPort.getDescriptivePortName();
            return portInfo;
        }
        
       
        private void setCommParameters(){
            SelectedPort.setBaudRate(115200);
        }
        private void initIOStream() {
//            boolean successful = false;
            is = SelectedPort.getInputStream();
            os = SelectedPort.getOutputStream();
            // writeData(0,0);
//            successful = true;
            
            
        }
        
        //Send Packet
        public void starter(){
            OpenPortFunc();
            initIOStream();
            setCommParameters();
//            logDataInput(openPortInfo());
        }
        public void sendUartPacket() throws IOException,InterruptedException{
            
//            ListPorts();
//            String name = "";
            
            
//            try{
                
            while(true){
//                StartHeader
                os.write(0x3A);
                //ID
                os.write(0xAA);
                os.write(0xAB);
//                //DLC
                os.write(0x07);
//                //Data
                os.write(0x01);
                os.write(0x01);
                os.write(0x01);
//                
//                //End Header
                os.write(0x2F);
                os.write(0x52);
                os.write(0x2F);
                os.write(0x46);
                
                Thread.sleep(100);
            }
        }
         public String message = "";
//
//        
//         public void message(){
//             String messenger;
//             return 
//         }
         public void setCommand(String command){
             this.message = command;
         }
         public String getCommand(){
             String messeger = this.message;
             return messeger;
         }
         
        public void ReceivePacket() throws IOException,InterruptedException{
//            one.setText("hi");

//            while (true){
             
//                
//                String comand="";
//                
//                is.read();
                
            
                
                
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                comand = comand+(byte)is.read();
//                setCommand(comand);
//                System.out.print(comand);
                
//                Thread.sleep(1000);
                
//            }
          

        SerialPort comPort = SerialPort.getCommPorts()[1];
        comPort.openPort();
        try{
            while(true){
                while(comPort.bytesAvailable()==0)
                    Thread.sleep(500);
                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                System.out.println("Read"+numRead+"bytes.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        comPort.closePort();
        }
}
//                os.flush();
//                while(c!='\n' && c!='\003'){
//                while(c!='\n' ){
////                    input 
//                    c= is.read();
////                    os.write((byte)0xAA);
//                    cmd.append(c);
//                     
//                }
//                if (c=='\003'){
//                    break;
//                }
//                //process (cmd);
//                
//            } 
//            }catch(IOException ioe){
//                //handl
//            }finally{
//                if(is!=null)
//                {
//                    try{
//                        is.close();
//                    }catch(IOException ex){
//                        
//                    }
//                }
//                if(os!=null)
//                {
//                    try{
//                        os.close();
//                    }catch(IOException ex)
//                    {
//                        
//                    }
//                }
//                if(SelectedPort!=null)
//                {
//                    ClosePortFucn();
//                }
//            }
//            return name;
//        }
       
        //log
//        public String logDataInput(String logData) {
//              LogOutputData = LogOutputData + logData;
//              return LogOutputData;
//        }
             
//}

   
    


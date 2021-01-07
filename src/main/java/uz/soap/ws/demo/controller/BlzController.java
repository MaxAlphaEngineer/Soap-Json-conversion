package uz.soap.ws.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.soap.ws.demo.SoapClient;
import uz.soap.ws.demo.stub.DetailsType;
import uz.soap.ws.demo.stub.GetBankResponseType;
import uz.soap.ws.demo.stub.GetBankType;
import uz.soap.ws.demo.stub.ObjectFactory;

@RestController
@RequestMapping("/")
public class BlzController {

    @Autowired
    private SoapClient soapClient;

    @GetMapping
    public DetailsType sum(@RequestParam String code) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(code);
// BlzServiceAdapter blzServiceAdapter=new BlzServiceAdapter();

        GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",
                objectFactory.createGetBank(type));
        return response.getDetails();
    }
}
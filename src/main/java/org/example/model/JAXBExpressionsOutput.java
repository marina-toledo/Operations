package org.example.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "expressions")
public class JAXBExpressionsOutput extends ExpressionsOutput {

    public JAXBExpressionsOutput(ExpressionsOutput expressionsOutput) {
        this.result = expressionsOutput.result;
    }

    public JAXBExpressionsOutput() {
        super();
    }

    @XmlElement
    public void setResult(List<Result> result) {
        this.result = result;
    }

    public List<Result> getResult() {
        return result;
    }
}
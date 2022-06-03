package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpressionsOutput {
    List<Result> result;

    public void setResult(List<Result> result) {
        this.result = result;
    }
}

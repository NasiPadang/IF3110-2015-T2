/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wsdl;

import java.util.List;

/**
 *
 * @author user
 */
public class ExampleUsageService {
    public static void main(String args[]){
        StackExchangeImplService stackExchangeService = new StackExchangeImplService();
        org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
        QuestionArray allQuestion = stackExchange.getAllQuestion("");
        List<Question> item = allQuestion.item;
        System.out.println(item.get(0).content);
    }
}


package org.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StackExchange", targetNamespace = "http://jaxws.org/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StackExchange {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/registerRequest", output = "http://jaxws.org/StackExchange/registerResponse")
    public boolean register(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/updateVoteQuestionRequest", output = "http://jaxws.org/StackExchange/updateVoteQuestionResponse")
    public int updateVoteQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/deleteQuestionRequest", output = "http://jaxws.org/StackExchange/deleteQuestionResponse")
    public boolean deleteQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/updateVoteAnswerRequest", output = "http://jaxws.org/StackExchange/updateVoteAnswerResponse")
    public int updateVoteAnswer(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/addQuestionRequest", output = "http://jaxws.org/StackExchange/addQuestionResponse")
    public int addQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.jaxws.QuestionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/getAllQuestionRequest", output = "http://jaxws.org/StackExchange/getAllQuestionResponse")
    public QuestionArray getAllQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/addAnswerRequest", output = "http://jaxws.org/StackExchange/addAnswerResponse")
    public boolean addAnswer(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.jaxws.AnswerArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/getAllAnswerRequest", output = "http://jaxws.org/StackExchange/getAllAnswerResponse")
    public AnswerArray getAllAnswer(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/editQuestionRequest", output = "http://jaxws.org/StackExchange/editQuestionResponse")
    public int editQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.jaxws.Question
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/getQuestionRequest", output = "http://jaxws.org/StackExchange/getQuestionResponse")
    public Question getQuestion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.jaxws.Answer
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/getAnswerRequest", output = "http://jaxws.org/StackExchange/getAnswerResponse")
    public Answer getAnswer(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://jaxws.org/StackExchange/loginRequest", output = "http://jaxws.org/StackExchange/loginResponse")
    public String login(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

}

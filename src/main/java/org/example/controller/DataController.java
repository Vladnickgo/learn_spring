package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class DataController {
    @GetMapping("")
    public String getStarted() {
        String firstPageMarkUp = "<h1>REST API Basics</h1>";
        firstPageMarkUp += "<hr>";
        firstPageMarkUp += "<h3>The application expose REST APIs to perform the following operations:</h3>" +
                "<ul style='font-size:14pt;'>" +
                "    <li>CRUD operations for GiftCertificate;</li>" +
                "    <li>CRD operations for Tag.</li>" +
                "</ul>" +
                "<h3>Also the application implements: </h3>" +
                "<ul style='font-size:14pt;'>" +
                "    <li>Get certificates by tag name;</li>"+
                "    <li>search by part of name/description;</li>" +
                "    <li>sort by date or by name ASC/DESC;</li>"+
                "    <li>implement ability to apply both sort type at the same time.</li>" +
                "</ul>";
        return firstPageMarkUp;
    }

}

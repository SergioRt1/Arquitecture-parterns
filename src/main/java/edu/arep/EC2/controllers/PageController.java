package edu.arep.EC2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @GetMapping
    public @ResponseBody String getPage() {
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Users app</title>\n" +
                "</head>\n" +
                "<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    function submitForm() {\n" +
                "        var name = document.getElementById('name').value;\n" +
                "        var lastName = document.getElementById('lastName').value;\n" +
                "        var headers = {'Content-Type': 'application/json'};\n" +
                "        var Url = \"/user\";\n" +
                "        var body = {\"name\": name,\"last_name\": lastName};\n" +
                "        axios({\n" +
                "            method: 'post',\n" +
                "            url: Url,\n" +
                "            data: body\n" +
                "        }).then(data => document.getElementById('response').innerHTML = \"Response: \" + JSON.stringify(data.data))\n" +
                "    .catch(err => alert(err));\n" +
                "    }\n" +
                "    function search() {\n" +
                "        var id = document.getElementById('id').value;\n" +
                "        var headers = {'Content-Type': 'application/json'};\n" +
                "        var Url = \"/user/\" + id;\n" +
                "        axios({\n" +
                "            method: 'get',\n" +
                "            url: Url,\n" +
                "        }).then(data => document.getElementById('response').innerHTML = \"Response: \" + JSON.stringify(data.data))\n" +
                "    .catch(err => alert(err));\n" +
                "    }\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "<body bgcolor=\"#afafaf\">\n" +
                "<center>\n" +
                "    <h4>Users App Demo</h4>\n" +
                "    <input id=\"name\" type=\"text\" placeholder=\"Name\" onsubmit=\"submitForm()\"/><br><br>\n" +
                "    <input id=\"lastName\" type=\"text\" placeholder=\"Last name\" onsubmit=\"submitForm()\"/><br><br>\n" +
                "    <input type=\"button\" value=\"save\" onclick=\"submitForm()\"/><br><br>\n" +
                "    <input id=\"id\" type=\"text\" placeholder=\"Id (Empty searchAll)\" onsubmit=\"search()\"/><br><br>\n" +
                "    <input type=\"button\" value=\"search\" onclick=\"search()\"/><br><br>\n" +
                "    <label id=\"response\"></label>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>";
    }
}

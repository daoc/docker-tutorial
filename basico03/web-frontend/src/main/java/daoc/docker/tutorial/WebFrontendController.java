package daoc.docker.tutorial;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebFrontendController {
	@Value("${usrval.restbackend.server}")
	private String server;
	@Value("${usrval.restbackend.port}")
	private String port;
	@Value("${usrval.restbackend.path}")
	private String path;
	
	private String url;
	RestTemplate client = new RestTemplate();

    @PostConstruct
    public void init() {
		url = String.format("http://%s:%s%s", server, port, path);
		System.out.println(url);
    }

	//CREATE
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "create";
	}

	//UPDATE
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable("id") Long id) {
		Estudiante estud = client.getForObject(url + "/" + id, Estudiante.class);
		model.addAttribute("estudiante", estud);
		return "update";
	}	
	
	//CREATE & UPDATE
	@PostMapping("/doCreateUpdate")
	public String doCreateUpdate(Model model, Estudiante estud) {
		client.postForEntity(url, estud, String.class);
		return retrieve(model);
	}	
	
	// RETRIEVE
	@SuppressWarnings("unchecked")
	@GetMapping("/retrieve")
	public String retrieve(Model model) {
		List<Estudiante> datoSS = client.getForObject(url, List.class);
		model.addAttribute("estudiantes", datoSS);
		return "retrieve";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		Estudiante estud = client.getForObject(url + "/" + id, Estudiante.class);
		model.addAttribute("estudiante", estud);
		return "delete";
	}

	//DELETE
	@PostMapping("/doDelete")
	public String doDelete(Model model, Estudiante estud) {
		client.delete(url + "/" + estud.getId());
		return retrieve(model);
	}			
	
}


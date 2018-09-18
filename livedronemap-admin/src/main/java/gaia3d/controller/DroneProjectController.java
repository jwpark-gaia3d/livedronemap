package gaia3d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/drone-project/")
@Controller
public class DroneProjectController {

	/**
	 * Project 목록
	 * @param model
	 * @return
	 */
	@GetMapping(value = "list-drone-project")
	public String droneProjectList(Model model) {
		//List<DroneProject> projectList = projectService.getListProject(new Project());
		
//		model.addAttribute("projectListSize", projectList.size());
//		model.addAttribute("projectList", projectList);
		
		return "/drone-project/list-drone-project";
	}
	
	/**
	 * Project 목록
	 * @param model
	 * @return
	 */
	@GetMapping(value = "list-image")
	public String imageList(Model model) {
		//List<DroneProject> projectList = projectService.getListProject(new Project());
		
//		model.addAttribute("projectListSize", projectList.size());
//		model.addAttribute("projectList", projectList);
		
		return "/drone-project/list-image";
	}
}

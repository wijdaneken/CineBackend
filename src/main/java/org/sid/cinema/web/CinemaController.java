package org.sid.cinema.web;
import javax.validation.Valid;
import org.sid.cinema.dao.CategorieRepository;
import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.ProjectionRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Categorie;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Projection;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CinemaController {
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping(path = "/cine")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		Page<Cinema> pageCinemas = cinemaRepository.findByNameContains(mc, PageRequest.of(page, size));

		model.addAttribute("cinemas", pageCinemas.getContent());
		model.addAttribute("pages", new int[pageCinemas.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		return "cinemas";
	}

	@GetMapping("/formcinema")
	public String formcinema(Model model) {
		model.addAttribute("cinema", new Cinema());
		model.addAttribute("mode", "new");
		return "formcinema";
	}

	@PostMapping(path = "/saveCinema")
	public String saveCinema(@Valid Cinema cinema, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formcinema";
		cinemaRepository.save(cinema);
		return "formcinema";
	}

	@GetMapping("/formcineupdate")
	public String editCine(Model model, Long id) {
		Cinema c = cinemaRepository.findById(id).get();
		model.addAttribute("cinema", c);
		model.addAttribute("mode", "edit");
		return "formcinema";
	}

	@GetMapping(path = "/deletecinema")
	public String delete(Long id, String keyword, int page, int size, Model model) {
		cinemaRepository.deleteById(id);
		return list(model, page, size, keyword);

	}

	@GetMapping(path = "/Films")
	public String listf(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		Page<Film> pageFilms = filmRepository.findByTitreContains(mc, PageRequest.of(page, size));

		model.addAttribute("Films", pageFilms.getContent());
		model.addAttribute("pages", new int[pageFilms.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		return "Films";
	}

	@GetMapping("/formfilm")
	public String formfilm(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("mode", "new");
		return "formfilm";
	}

	@PostMapping(path = "/savefilm")
	public String saveFilm(@Valid Film film, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formfilm";
		filmRepository.save(film);
		return "formfilm";
	}

	@GetMapping("/formfilmup")
	public String editfilm(Model model, Long id) {
		Film f = filmRepository.findById(id).get();
		model.addAttribute("film", f);
		model.addAttribute("mode", "edit");
		return "formfilm";
	}

	@GetMapping(path = "/deletefilm")
	public String deletef(Long id, String keyword, int page, int size, Model model) {
		filmRepository.deleteById(id);
		return listf(model, page, size, keyword);

	}
	/*
	 * @GetMapping(path ="/projectionss" ) public String lisstt (Model model,
	 * 
	 * @RequestParam (name= "page", defaultValue= "0")int page,
	 * 
	 * @RequestParam (name= "size", defaultValue= "6")int size,
	 * 
	 * @RequestParam (name= "keyword", defaultValue= "")String mc) {
	 * 
	 * Page<Projection>pageprojections=projectionRepository.findAll(
	 * PageRequest.of(page, size));
	 * model.addAttribute("projections",pageprojections.getContent());
	 * model.addAttribute("pages", new int[pageprojections.getTotalPages()]);
	 * model.addAttribute("currentPage", page); model.addAttribute("keyword", mc);
	 * model.addAttribute("size", size); return "projections"; }
	 * 
	 * @GetMapping(path ="/deleteProj") public String dddelete2(Long id,String
	 * keyword,int page,int size,Model model) { projectionRepository.deleteById(id);
	 * return lisstt(model,page,size,keyword); }
	 * 
	 * @RequestMapping(value="/Formproj",method=RequestMethod.GET) public String
	 * Formproj(Model model) { model.addAttribute("projection",new Projection());
	 * return"Formproj"; }
	 * 
	 * @RequestMapping(value="/Sssaveproj",method=RequestMethod.POST) public String
	 * save(Projection projection) {projectionRepository.save(projection);
	 * return"redirect:projectionss"; }
	 * 
	 * @PostMapping(path = "/saveprojection") public String saveProjection(
	 * Projection projection) { projectionRepository.save(projection); return
	 * "redirect:projectionss"; }
	 * 
	 * @GetMapping("/projectionupdate") public String editprojection(Model model,
	 * Long id) { Projection p = projectionRepository.findById(id).get();
	 * model.addAttribute("projection", p); model.addAttribute("mode", "edit");
	 * return "updateprojection"; }
	 */

	
	@GetMapping(path ="/projectionss" )
	public String lisstt (Model model, 
			@RequestParam (name= "page", defaultValue= "0")int page,
			@RequestParam (name= "size", defaultValue= "6")int size,
			@RequestParam (name= "keyword", defaultValue= "")String mc) {
	
		Page<Projection>pageprojections=projectionRepository.findAll(
				PageRequest.of(page, size));
		model.addAttribute("projections",pageprojections.getContent());
		model.addAttribute("pages", new int[pageprojections.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", mc);
		model.addAttribute("size", size);
	return "projections";		}
//Supprimer projections************
	@GetMapping(path ="/deleteProj")
	public String delete22(Long id,String keyword,int page,int size,Model model) {

		projectionRepository.deleteById(id);
	       return lisstt(model,page,size,keyword);
	}
	
	
	
	  //Ajouter Projection************
	  
	  @RequestMapping(value="/Formproj",method=RequestMethod.GET) public String
	  Formproj(Model model) { model.addAttribute("projection",new Projection());
	  return"Formproj"; }
	  
	  @RequestMapping(value="/Sssaveproj",method=RequestMethod.POST) public String
	  save(@Valid Projection projection) {projectionRepository.save(projection);
	  return"redirect:projectionss"; }
	 


	
	//update Proj
	@PostMapping(path = "/saveprojection")
	public String saveProjection(@Valid Projection projection) {
		projectionRepository.save(projection);
		return "redirect:projectionss";
	}
	@GetMapping("/projectionupdate")
	public String editprojection(Model model, Long id) {
		Projection p = projectionRepository.findById(id).get();
		model.addAttribute("projection", p);
		model.addAttribute("mode", "edit");
		return "updateprojection";
	}

	

	@GetMapping(path ="/ticketss" )
	public String listticket (Model model, 
			@RequestParam (name= "page", defaultValue= "0")int page,
			@RequestParam (name= "size", defaultValue= "6")int size,
			@RequestParam (name= "keyword", defaultValue= "")String mc) {
		
		Page<Ticket>pageticket=ticketRepository.findAll(PageRequest.of(page, size));
			
		model.addAttribute("tickets",pageticket.getContent());
		model.addAttribute("pages", new int[pageticket.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", mc);
		model.addAttribute("size", size);
	return "tickets";		
	}
	
	//Ajouter Ticket************
	@RequestMapping(value="/Formticket",method=RequestMethod.GET)
	public String Formticket(Model model)
    {
		model.addAttribute("ticket",new Ticket());
    return"Formticket";
    }
	@RequestMapping(value="/Savetikcet11",method=RequestMethod.POST)
	public String save(Ticket ticket)
    {ticketRepository.save(ticket);
    return"redirect:ticketss";
    }
	
	@PostMapping(path = "/savetikcet")
	public String savetikcet( Ticket ticket) {
		ticketRepository.save(ticket);
		return "redirect:ticketss";
	}
	@GetMapping("/ticketupdate")
	public String edittikcet(Model model, Long id) {
		Ticket t = ticketRepository.findById(id).get();
		model.addAttribute("ticket", t);
		model.addAttribute("mode", "edit");
		return "updatetikcet";
	}

	@GetMapping(path = "/deleteticket")
	public String deleteticket(Long id, String keyword, int page, int size, Model model) {
		ticketRepository.deleteById(id);
		return listticket(model, page, size, keyword);

	}
	
	@GetMapping(path = "/categories")
	public String listc(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		Page<Categorie> pageCategorie = categorieRepository.findByNameContains(mc, PageRequest.of(page, size));

		model.addAttribute("categories", pageCategorie.getContent());
		model.addAttribute("pages", new int[pageCategorie.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		return "categories";
	}

	@GetMapping("/formcategorie")
	public String formcategorie(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("mode", "new");
		return "formcategorie";
	}

	@PostMapping(path = "/saveCategorie")
	public String savecategorie(@Valid Categorie categorie, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formcategorie";
		categorieRepository.save(categorie);
		return "formcategorie";
	}

	@GetMapping("/formcatupdate")
	public String editCat(Model model, Long id) {
		Categorie c = categorieRepository.findById(id).get();
		model.addAttribute("categorie", c);
		model.addAttribute("mode", "edit");
		return "formcategorie";
	}

	@GetMapping(path = "/deletecategorie")
	public String deletec(Long id, String keyword, int page, int size, Model model) {
		categorieRepository.deleteById(id);
		return listc(model, page, size, keyword);

	}
}



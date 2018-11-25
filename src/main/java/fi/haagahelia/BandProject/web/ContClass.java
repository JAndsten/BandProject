package fi.haagahelia.BandProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.BandProject.domain.Album;
import fi.haagahelia.BandProject.domain.AlbumRepository;
import fi.haagahelia.BandProject.domain.Band;
import fi.haagahelia.BandProject.domain.BandRepository;

@Controller

public class ContClass {
	@Autowired
	private BandRepository brepository;
	
	@Autowired
	private AlbumRepository arepository;
	
	// login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
    // show all bands and albums
	@RequestMapping("/list")
	public String bandList(Model model) {
        model.addAttribute("bands", brepository.findAll());
        model.addAttribute("albums", arepository.findAll());
		return "bandList";
	}
	
	// RESTful service to show all bands
    @RequestMapping(value="/artists", method = RequestMethod.GET)
    public @ResponseBody List<Band> bandListRest() {	
        return (List<Band>) brepository.findAll();
    }

	// RESTful service to show all bands by id
    @RequestMapping(value="/artists/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Band> findBandRest(@PathVariable("id") Long id) {	
    	return brepository.findById(id);
    }
    
	// RESTful service to show all albums by id
    @RequestMapping(value="/albums/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("aId") Long aId) {	
    	return arepository.findById(aId);
    }
    
	// RESTful service to show all albums
    @RequestMapping(value="/albums", method = RequestMethod.GET)
    public @ResponseBody List<Album> albumListRest() {	
        return (List<Album>) arepository.findAll();
    }
	
	// add a band
	@RequestMapping("/band")
	public String addBand(Model model){
    	model.addAttribute("band", new Band());
		return "band";
	}
	
	//add an album
	@RequestMapping("/album")
	public String addAlbum(Model model){
		model.addAttribute("album", new Album());
        model.addAttribute("bands", brepository.findAll()); // so you can choose the artist from a dropdown menu with all artists
		return "album";
	}

	// saves a band
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Band band){
        brepository.save(band);
        return "redirect:list";
    }
    
    // saves an album
    @RequestMapping(value = "/aSave", method = RequestMethod.POST)
    public String aSave(Album album){
        arepository.save(album);
        return "redirect:list";
    }
    
    // Deletes a band
    @RequestMapping(value = "/bdelete/{id}", method = RequestMethod.GET)
    public String deleteBand(@PathVariable("id") Long id, Model model) {
    	brepository.deleteById(id);
        return "redirect:../list";
    }
    
    // Deletes an album
    @RequestMapping(value = "/adelete/{aId}", method = RequestMethod.GET)
    public String deleteAlbum(@PathVariable("aId") Long aId, Model model) {
    	arepository.deleteById(aId);
        return "redirect:../list";
    }     
	
}
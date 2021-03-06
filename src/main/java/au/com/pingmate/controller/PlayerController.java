package au.com.pingmate.controller;

import au.com.pingmate.domain.PingPongPlayer;
import au.com.pingmate.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("player/list", "command", new PingPongPlayer());
        model.addObject("players", playerService.listActivePlayers());
        return model;
    }

    @RequestMapping(value="/leaderboard", method = RequestMethod.GET)
    public ModelAndView ranking() {
        return new ModelAndView("player/leaderboard", "players", playerService.listLeaderboard());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAction(@ModelAttribute("pingPongPlayer") PingPongPlayer pingPongPlayer) {
        if (!pingPongPlayer.getName().equals("")) {
            //todo: think of a better way to prevent no name save
            playerService.addPlayer(pingPongPlayer);
        }
        return "redirect:/player";
    }
}
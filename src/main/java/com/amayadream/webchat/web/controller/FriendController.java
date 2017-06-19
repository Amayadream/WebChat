package com.amayadream.webchat.web.controller;

import com.amayadream.webchat.common.result.ResultConstant;
import com.amayadream.webchat.common.result.Results;
import com.amayadream.webchat.common.util.Constants;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  Amayadream
 * @date :  2017.06.19 22:41
 */
@RestController
@RequestMapping(value = "/friend")
@SessionAttributes({Constants.SESSION_USERID, Constants.SESSION_USER})
public class FriendController {

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Results friend(@ModelAttribute(Constants.SESSION_USERID) String userId) {
        return Results.ok(ResultConstant.SUCCESS);
    }

}

package com.imatia.implatform.prototypen.ws.core.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.implatform.prototypen.api.core.service.ITagsService;
import com.imatia.implatform.prototypen.model.core.dao.TagsDao;
import com.ontimize.jee.server.multitenant.MultiTenantContextHolder;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/tags")
@ComponentScan(basePackageClasses={com.imatia.implatform.prototypen.api.core.service.ITagsService.class})
public class TagsController extends ORestController<ITagsService> {

    private final ITagsService tagsService;

    @Autowired
    TagsController(ITagsService tagsService) {
        this.tagsService = tagsService;
    }

    @Override
    public ITagsService getService() {
        return this.tagsService;
    }

	@GetMapping(path = "/patata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> patata() {
		try {
	        MultiTenantContextHolder.setTenant("demo");
	        
	        Map<String, Object> keyMap = new HashMap<>();
	        //keyMap.put(TagsDao.TAG_ID, UUID.fromString("bda2e9bb-ef86-4774-b92f-193b57117e11"));
	        keyMap.put(TagsDao.TAG_ID, "bda2e9bb-ef86-4774-b92f-193b57117e11");
	        
	        Map<String, Object> attrMap = new HashMap<>();
	        attrMap.put(TagsDao.DESCRIPTION, "Test 2");
	        this.tagsService.tagsUpdate(attrMap, keyMap);

	        return new ResponseEntity<>("OK", HttpStatus.OK);
		} catch (final Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

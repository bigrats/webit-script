// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.web.loaders;

import javax.servlet.ServletContext;
import webit.script.exceptions.ResourceNotFoundException;
import webit.script.loaders.AbstractLoader;
import webit.script.loaders.Resource;
import webit.script.loaders.impl.resources.FileResource;

/**
 *
 * @author Zqq
 */
public class ServletLoader extends AbstractLoader {

    private ServletContext servletContext;

    public Resource get(String name) throws ResourceNotFoundException {
        final String realpath;
        if ((realpath = servletContext.getRealPath(getRealPath(name))) != null) {
            return new FileResource(realpath, encoding);
        } else {
            throw new ResourceNotFoundException("Not found: ".concat(name));
        }
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

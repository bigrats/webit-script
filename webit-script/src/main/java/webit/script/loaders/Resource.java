// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.loaders;

import java.io.IOException;
import java.io.Reader;

public interface Resource {

    boolean isModified();

    Reader openReader() throws IOException;
}
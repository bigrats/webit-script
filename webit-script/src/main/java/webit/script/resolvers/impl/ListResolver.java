// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.resolvers.impl;

import java.util.Collection;
import java.util.List;
import webit.script.exceptions.ScriptRuntimeException;
import webit.script.resolvers.GetResolver;
import webit.script.resolvers.MatchMode;
import webit.script.resolvers.SetResolver;
import webit.script.util.StringUtil;

/**
 *
 * @author Zqq
 */
public class ListResolver implements GetResolver, SetResolver {

    public MatchMode getMatchMode() {
        return MatchMode.INSTANCEOF;
    }

    public Class<?> getMatchClass() {
        return Collection.class;
    }

    public Object get(Object object, Object property) {
        if (property instanceof Number) {
            try {
                return ((List) object).get(((Number) property).intValue());
            } catch (IndexOutOfBoundsException e) {
                throw new ScriptRuntimeException(StringUtil.concat("index out of bounds:", property));
            }
        } else {
            if (property == "size" || "size".equals(property)) {
                return ((List) object).size();
            } else if (property == "isEmpty" || "isEmpty".equals(property)) {
                return ((List) object).isEmpty();
            }
            throw new ScriptRuntimeException(StringUtil.concat("Invalid property or can't read: java.util.List#", property));
        }
    }

    @SuppressWarnings("unchecked")
    public boolean set(Object object, Object property, Object value) {
        if (property instanceof Number) {
            try {
                ((List) object).set(((Number) property).intValue(), value);
                return true;
            } catch (IndexOutOfBoundsException e) {
                throw new ScriptRuntimeException(StringUtil.concat("index out of bounds:", property));
            }
        } else {
            throw new ScriptRuntimeException(StringUtil.concat("Invalid property or can't write: java.util.List#", property));
        }
    }
}

// Copyright (c) 2013, Webit Team. All Rights Reserved.
package webit.script.resolvers;

/**
 *
 * @author Zqq
 */
public abstract interface Resolver {

    MatchMode getMatchMode();

    Class<?> getMatchClass();
}

package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedDeque;

/**
 *
 * @author Isaac Griffith
 */
public class DequeStackMerge {

    /**
     * Merges the contents of the second stack (from) into the bottom of the
     * first stack (into) while preserving the order of the original stacks.
     * Note that if either stack is null, nothing happens.
     *
     * @param <E> Element type of the stacks
     * @param into Stack into which the other stack will be merged
     * @param from Stack which is merged into the bottom of the other stack.
     */
    public static <E> void dequeStackMerge(final Stack<E> into, Stack<E> from) {
        if(from != null || into != null)
        {
            from.transfer(into);


        }

    }
}

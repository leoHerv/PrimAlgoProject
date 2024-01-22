package src.list;

import java.util.Iterator;

/**
 * Simply chained Generic list  @param <T>  the type parameter
 * @param <T> the type parameter
 */
public class List<T> implements Iterable<T>
{
    /** Head of the list */
    private Node<T> pri_head;

    /** Size of the list*/
    private int pri_size;

    /**
     * Instantiates a new List.
     */
    public List()
    {
        pri_head = null;
        pri_size = 0;
    }

    /**
     * Add an element to the list.
     * @param data the data
     */
    public void add(T data)
    {
        pri_head = new Node<>(data, pri_head);
        pri_size++;
    }

    /**
     * Give the size of the list.
     * @return The size.
     */
    public int size()
    {
        return pri_size;
    }

    /** Give an iterator on the list.
     * @return An iterator on the list.
     */
    @Override
    public Iterator<T> iterator()
    {
        return new ListIterator();
    }

    //========================//
    //===   Intern Class   ===//
    //========================//

    /** Node for the list. */
    private class Node<T>
    {
        private T pri_data;
        private Node<T> pri_next;

        /**
         * Instantiates a new Node.
         * @param data The data
         * @param next The next
         */
        public Node(T data, Node<T> next)
        {
            pri_data = data;
            pri_next = next;
        }

        /**
         * Give the data of this node.
         * @return The data
         */
        public T getData()
        {
            return pri_data;
        }

        /**
         * Give the next node.
         * @return The next one.
         */
        public Node<T> getNext()
        {
            return pri_next;
        }
    }

    /** Iterator to iterate through the list. */
    private class ListIterator implements Iterator<T>
    {
        /** Current node that we iterate through */
        private Node<T> pri_current;

        /**
         * Instantiates a new List iterator.
         */
        ListIterator()
        {
            pri_current = pri_head;
        }

        @Override
        public boolean hasNext()
        {
            return pri_current != null;
        }

        @Override
        public T next()
        {
            if (hasNext())
            {
                T data = pri_current.getData();
                pri_current = pri_current.getNext();
                return data;
            }
            return null;
        }
    }
}

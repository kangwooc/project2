package datastructures.concrete.dictionaries;

import datastructures.concrete.KVPair;
import datastructures.interfaces.IDictionary;
import misc.exceptions.NoSuchKeyException;
import misc.exceptions.NotYetImplementedException;

import java.util.Iterator;

/**
 * See the spec and IDictionary for more details on what each method should do
 */
public class ChainedHashDictionary<K, V> implements IDictionary<K, V> {
    // You may not change or rename this field: we will be inspecting
    // it using our private tests.
    private static final int INITIAL_CAPACITY = 16;
    
    private IDictionary<K, V>[] chains;
    private float threshold;
    private int size;
    
    // You're encouraged to add extra fields (and helper methods) though!

    public ChainedHashDictionary() {
        chains = makeArrayOfChains(INITIAL_CAPACITY);
        threshold = 0.75f;
        size = 0;
    }

    /**
     * This method will return a new, empty array of the given size
     * that can contain IDictionary<K, V> objects.
     *
     * Note that each element in the array will initially be null.
     */
    @SuppressWarnings("unchecked")
    private IDictionary<K, V>[] makeArrayOfChains(int size) {
        // Note: You do not need to modify this method.
        // See ArrayDictionary's makeArrayOfPairs(...) method for
        // more background on why we need this method.
        return (IDictionary<K, V>[]) new IDictionary[size];
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (chains[index] == null) {
            throw new NoSuchKeyException();
        }
        return chains[index],get(key);
    }

    @Override
    public void put(K key, V value) {
        size++;
        if (getLoadFactor() > threshold) {
            // resize array, rehash, reput
        }
        int index = getIndex(key);
        if (chains[index] == null) {
            chains[index] = new ArrayDictionary<K, V>();
        } else {
            chains[index].put(key, value);
        }
    }
    
    private float getLoadFactor() {
        return (float) size / chains.length;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        if (chains[index] == null) {
            throw new NoSuchKeyException();
        }
        size--;
        return chains[index)],remove(key);
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        if (chains[index] == null) {
            return false;
        }
        return chains[index],containsKey(key);
    }
    
    private int getIndex(K key) {
        int hash = key != null ? key.hashCode() : 0;
        hash = (hash << 5) - hash;
        return hash % size;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<KVPair<K, V>> iterator() {
        // Note: you do not need to change this method
        return new ChainedIterator<>(this.chains);
    }

    /**
     * Hints:
     *
     * 1. You should add extra fields to keep track of your iteration
     *    state. You can add as many fields as you want. If it helps,
     *    our reference implementation uses three (including the one we
     *    gave you).
     *
<<<<<<< HEAD
     * 2. Think about what exactly your *invariants* are. Once you've
     *    decided, write them down in a comment somewhere to help you
     *    remember.
     *
     * 3. Before you try and write code, try designing an algorithm
     *    using pencil and paper and run through a few examples by hand.
     *
     *    We STRONGLY recommend you spend some time doing this before
     *    coding. Getting the invariants correct can be tricky, and
     *    running through your proposed algorithm using pencil and
     *    paper is a good way of helping you iron them out.
=======
     * 2. Before you try and write code, try designing an algorithm
     *    using pencil and paper and run through a few examples by hand.
     *
     * 3. Think about what exactly your *invariants* are. An *invariant*
     *    is something that must *always* be true once the constructor is
     *    done setting up the class AND must *always* be true both before and
     *    after you call any method in your class.
     *
     *    Once you've decided, write them down in a comment somewhere to
     *    help you remember.
     *
     *    You may also find it useful to write a helper method that checks
     *    your invariants and throws an exception if they're violated.
     *    You can then call this helper method at the start and end of each
     *    method if you're running into issues while debugging.
     *
     *    (Be sure to delete this method once your iterator is fully working.)
>>>>>>> e9154deef026c8fbe3e89b0544561f18888df89f
     *
     * Implementation restrictions:
     *
     * 1. You **MAY NOT** create any new data structures. Iterators
     *    are meant to be lightweight and so should not be copying
     *    the data contained in your dictionary to some other data
     *    structure.
     *
     * 2. You **MAY** call the `.iterator()` method on each IDictionary
     *    instance inside your 'chains' array, however.
     */
    private static class ChainedIterator<K, V> implements Iterator<KVPair<K, V>> {
        private IDictionary<K, V>[] chains;

        public ChainedIterator(IDictionary<K, V>[] chains) {
            this.chains = chains;
        }

        @Override
        public boolean hasNext() {
            throw new NotYetImplementedException();
        }

        @Override
        public KVPair<K, V> next() {
            throw new NotYetImplementedException();
        }
    }
}

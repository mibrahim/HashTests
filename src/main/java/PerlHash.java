
/**
 * Perl's Hash implementation.
 *
 * @author nahi@ruby-lang.org
 *
 * Downloaded from: https://github.com/jruby/jruby/blob/5e4aab28b26fd127112b76fabfac9a33b64caf77/src/org/jruby/util/PerlHash.java
 *
 */
public class PerlHash {
    public static long hash(long key, byte[] src, int offset, int length) {
        for (int idx = 0; idx < length; ++idx) {
            key += (src[offset + idx] & 0xFF);
            key += (key << 10);
            key ^= (key >>> 6);
        }
        key += (key << 3);
        key ^= (key >>> 11);
        key += (key << 15);
        return key;
    }
}
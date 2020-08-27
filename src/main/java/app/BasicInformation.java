package app;

/**
 * The interface Basic information.
 *
 * @param <T> the type parameter
 */
public interface BasicInformation<T> {

    /**
     * Accept t.
     *
     * @param extractor the extractor
     * @return the t
     */
    T accept(DetailExtractor extractor);
}

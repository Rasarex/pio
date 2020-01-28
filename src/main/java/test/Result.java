package test;

class Result<T> {
    private T result;
    private boolean error;

    Result(T result, boolean error) {
        this.result = result;
        this.error = error;
    }

    public boolean ok() {
        return error;
    }

    public T unwrap() {
        if (!error) {
            Thread.dumpStack();
            System.exit(-1);
        }
        return result;
    }

}
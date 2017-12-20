package com.labs.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Validator<T> {

    private final T object;
    private final List<Throwable> exceptions = new ArrayList<>();


    private Validator(T object) {
        this.object = object;
    }

    public static <T> Validator<T> of(T object){
        return new Validator<>(object);
    }
/*
    public Validator<T> validate(Predicate<T> validation, String message){
        if(!validation.test(object)){
            exceptions.add(new IllegalStateException(message));
        }
        return this;
    }

    public Validator<T> validateIf(Predicate<T> validation, String message){
        if(validation.test(object)){
            exceptions.add(new IllegalStateException(message));
        }
        return this;
    }
*/
    public <X extends Throwable> Validator<T> validate(Predicate<T> validation, Supplier<? extends X> exceptionSupplier){
        if(validation.test(object)){
            exceptions.add(exceptionSupplier.get());
        }
        return this;
    }

    public <X extends Throwable> Validator<T> validateIf(Predicate<T> validation, Supplier<? extends X> exceptionSupplier){
        if(validation.test(object)){
            exceptions.add(exceptionSupplier.get());
        }
        return this;
    }
/*
    public <U> Validator<T> validate(Function<T, U> projection, Predicate<U> validation, String message){
        return validate(projection.andThen(validation::test)::apply, message);
    }

    public <U> Validator<T> validateIf(Function<T, U> projection, Predicate<U> validation, String message){
        return validateIf(projection.andThen(validation::test)::apply, message);
    }
*/
    public <U, X extends Throwable> Validator<T> validate(Function<T,U> projection, Predicate<U> validation, Supplier<? extends X> exceptionSupplier){
        return validate(projection.andThen(validation::test)::apply, exceptionSupplier);
    }

    public <U, X extends Throwable> Validator<T> validateIf(Function<T,U> projection, Predicate<U> validation, Supplier<? extends X> exceptionSupplier){
        return validateIf(projection.andThen(validation::test)::apply, exceptionSupplier);
    }

    public T get(){
        return object;
    }

    public boolean isSuccess() {
        return this.exceptions.isEmpty();
    }

    public Validator<T> execute() throws IllegalStateException {
        if (isSuccess()) {
            return this;
        }
        IllegalStateException e = new IllegalStateException();
        exceptions.forEach(e::addSuppressed);
        throw e;
    }

}
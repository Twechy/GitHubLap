package com.programmic.twechy.githublap;


import com.programmic.twechy.githublap.POJO_Models.Cars.Cars;
import com.programmic.twechy.githublap.Presenter.CarActivityPresenter;
import com.programmic.twechy.githublap.Repository.CarsRepository;
import com.programmic.twechy.githublap.View.CarActivityView;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarsActivityPresenterTest {

    @Test
    public void shouldPassCarsToView() {

        // give
        CarActivityView view = new MockView();
        CarsRepository carsRepository = () -> Arrays.asList(new Cars(), new Cars(), new Cars());

        // when
        CarActivityPresenter carActivityPresenter = new CarActivityPresenter(view, carsRepository);
        carActivityPresenter.loadCars();

        //then
        Assert.assertEquals(true, ((MockView) view).displayCarsWithCarsCalled);

    }

    @Test
    public void shouldHandleNoCarsFound() {

        CarActivityView view = new MockView();
        CarsRepository carsRepository = Collections::emptyList;

        CarActivityPresenter carActivityPresenter = new CarActivityPresenter(view, carsRepository);
        carActivityPresenter.loadCars();

        Assert.assertEquals(true, ((MockView) view).displayCarsWithNoCarsCalled);

    }

    private class MockView implements CarActivityView {

        boolean displayCarsWithCarsCalled;
        boolean displayCarsWithNoCarsCalled;

        @Override
        public void displayCars(List<Cars> carsList) {

            if (carsList.size() == 3) displayCarsWithCarsCalled = true;
        }

        @Override
        public void displayNoCars() {

            displayCarsWithNoCarsCalled = true;
        }
    }
}
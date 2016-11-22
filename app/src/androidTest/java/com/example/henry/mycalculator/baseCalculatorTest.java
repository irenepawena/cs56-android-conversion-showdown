package com.example.henry.mycalculator;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by irenepatt on 11/21/16.
 */

//Test cases to test the baseCalculator activity.
// Run the test by right clicking "com.example.henry.mycalculator (androidTest)" and select the green triangle that says "Run Tests in.."
//Just wait and watch the tests to run!
@RunWith(AndroidJUnit4.class)
public class baseCalculatorTest {
    @Rule
    public ActivityTestRule<baseCalculator> mActivityRule =
            new ActivityTestRule<>(baseCalculator.class);

    @Test
    public void testCalcDec() {
        onView(withId(R.id.firstInput))
                .perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.secondInput))
                .perform(typeText("1010"), closeSoftKeyboard());

        onView(withId(R.id.inputOneBaseButton)).perform(click());
        onView(withText("Dec")).perform(click());

        onView(withId(R.id.inputTwoBaseButton)).perform(click());
        onView(withText("Dec")).perform(click());

        onView(withId(R.id.resultBaseButton)).perform(click());
        onView(withText("Dec")).perform(click());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.baseCalcResult))
                .check(matches(withText("1020")));
    }

    @Test
    public void testCalcBin() {
        onView(withId(R.id.firstInput))
                .perform(typeText("11"), closeSoftKeyboard());
        onView(withId(R.id.secondInput))
                .perform(typeText("1010"), closeSoftKeyboard());

        onView(withId(R.id.inputOneBaseButton)).perform(click());
        onView(withText("Bin")).perform(click());

        onView(withId(R.id.inputTwoBaseButton)).perform(click());
        onView(withText("Bin")).perform(click());

        onView(withId(R.id.resultBaseButton)).perform(click());
        onView(withText("Dec")).perform(click());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.baseCalcResult))
                .check(matches(withText("13")));
    }

    @Test
    public void testCalcOctal() {
        onView(withId(R.id.firstInput))
                .perform(typeText("12"), closeSoftKeyboard());
        onView(withId(R.id.secondInput))
                .perform(typeText("7"), closeSoftKeyboard());

        onView(withId(R.id.inputOneBaseButton)).perform(click());
        onView(withText("Oct")).perform(click());

        onView(withId(R.id.inputTwoBaseButton)).perform(click());
        onView(withText("Oct")).perform(click());

        onView(withId(R.id.resultBaseButton)).perform(click());
        onView(withText("Bin")).perform(click());

        onView(withId(R.id.subtractButton)).perform(click());

        onView(withId(R.id.baseCalcResult))
                .check(matches(withText("11")));
    }

    @Test
    public void testCalcHex() {
        onView(withId(R.id.firstInput))
                .perform(typeText("F"), closeSoftKeyboard());
        onView(withId(R.id.secondInput))
                .perform(typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.inputOneBaseButton)).perform(click());
        onView(withText("Hex")).perform(click());

        onView(withId(R.id.inputTwoBaseButton)).perform(click());
        onView(withText("Hex")).perform(click());

        onView(withId(R.id.resultBaseButton)).perform(click());
        onView(withText("Oct")).perform(click());

        onView(withId(R.id.multiplyButton)).perform(click());

        onView(withId(R.id.baseCalcResult))
                .check(matches(withText("113")));
    }


}

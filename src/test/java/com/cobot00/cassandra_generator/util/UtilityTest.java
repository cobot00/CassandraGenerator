package com.cobot00.cassandra_generator.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

    @Test
    public void toLowerCamel() {
        assertThat(Utility.toLowerCamel("user_name"), is("userName"));
        assertThat(Utility.toLowerCamel("dept"), is("dept"));
    }

    @Test
    public void toUpperCamel() {
        assertThat(Utility.toUpperCamel("user_name"), is("UserName"));
        assertThat(Utility.toUpperCamel("dept"), is("Dept"));
    }

}

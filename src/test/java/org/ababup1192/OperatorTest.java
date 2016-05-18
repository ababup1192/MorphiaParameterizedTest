package org.ababup1192;

import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class OperatorTest {
    private static final String DATA_STORE_NAME = "parameterized";

    @Before
    public void preProcess() throws Exception {
        final Morphia morphia = new Morphia();

        MongoClient mongoClient = new MongoClient();
        mongoClient.dropDatabase(DATA_STORE_NAME);

        final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);

        // BaseParameterを継承しているものなら何でも代入可能
        datastore.save(new Entity(new IntegerParameter(1)));
        datastore.save(new Entity(new StringParameter("abc")));
        datastore.save(new Entity(new BooleanParameter(true)));
    }

    @Test
    public void testSelectIntegerEntity() {
        final Morphia morphia = new Morphia();
        final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
        // 比較もパラメーターに合わせて比較可能
        final Query<Entity> query = datastore.createQuery(Entity.class)
                .filter("base.value", 1);

        assertThat(query.asList().get(0), is(new Entity(new IntegerParameter(1))));
    }

    @Test
    public void testSelectStringEntity() {
        final Morphia morphia = new Morphia();
        final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
        final Query<Entity> query = datastore.createQuery(Entity.class)
                .filter("base.value", "abc");

        assertThat(query.asList().get(0), is(new Entity(new StringParameter("abc"))));
    }

    @Test
    public void testSelectBooleanEntity() {
        final Morphia morphia = new Morphia();
        final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
        final Query<Entity> query = datastore.createQuery(Entity.class)
                .filter("base.value", true);

        assertThat(query.asList().get(0), is(new Entity(new BooleanParameter(true))));
    }
}

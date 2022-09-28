import com.clean.architecture.orm.AnyORM;
import com.clean.architecture.queries.DBAny;

public class DBAnyImpl implements DBAny {

    @Override
    public AnyORM findAny() {

        AnyORM value = new AnyORM();
        value.setValue("it is a sample of value");

        return value;

    }
}

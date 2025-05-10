package Logica;

import Logica.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-09T20:42:07", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, String> descriptionTarea;
    public static volatile SingularAttribute<Tarea, Date> fechaLimite;
    public static volatile SingularAttribute<Tarea, Usuario> idUsuario;
    public static volatile SingularAttribute<Tarea, String> nombreTarea;
    public static volatile SingularAttribute<Tarea, Date> fechaCreacion;
    public static volatile SingularAttribute<Tarea, Integer> id;
    public static volatile SingularAttribute<Tarea, Boolean> completado;

}
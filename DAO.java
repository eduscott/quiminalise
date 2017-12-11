package DAO;

import java.util.ArrayList;

public interface DAO {
    public boolean save ();
    public boolean delete();
    public boolean update ();
    public boolean find ();
    public Object getOne ();
    public ArrayList <Object> getAll ();
}

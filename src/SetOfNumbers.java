import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by felipesfaria on 29/10/15.
 */
public class SetOfNumbers {
    //Numero de subconjuntos com os elemntos de 1 a N com tamanho entre o minimo e maximo
    private List<HashSet<Integer>> _sets = new ArrayList<>();
    private Set<Integer> _set = new HashSet<>();
    private final Integer  _n, _min, _max;
    private int _depth=0;

    public SetOfNumbers(int n, int min, int max){
        if(min>max)
            throw new IllegalArgumentException("Min is greater than max");
        if(n>max || n<min)
            throw new IllegalArgumentException("N is out of bounds");
        _n= n;
        _min = min;
        _max = max;
    }

    public List<HashSet<Integer>> Run(){
        GoDeeper();
        return _sets;
    }

    private void GoDeeper() {
        _depth++;
        if(_depth > _max) return;
        for(int i = _depth;i<=_n;i++){
            _set.add(i);
            if(_depth>=_min)
                _sets.add(CopySet());
            GoDeeper();
            _set.remove(i);
        }
        _depth--;
    }

    private HashSet<Integer> CopySet(){
        HashSet<Integer> s = new HashSet<>();
        for(Integer i : _set){
            s.add(i);
        }
        return s;
    }
}

package de.StundenplanHelden.schulplaner_android_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menueleiste#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menueleiste extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menueleiste() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menueleiste.
     */
    // TODO: Rename and change types and number of parameters
    public static Menueleiste newInstance(String param1, String param2) {
        Menueleiste fragment = new Menueleiste();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menueleiste, container, false);
        ImageView timetable = (ImageView) view.findViewById(R.id.timetable);
        ImageView tasks = (ImageView) view.findViewById(R.id.tasks);
        ImageView grades = (ImageView) view.findViewById(R.id.grades);
        ImageView settings = (ImageView) view.findViewById(R.id.settings);

        timetable.setOnClickListener(v -> startActivity(new Intent(getActivity(), TimetableActivity.class)));
        tasks.setOnClickListener(v -> startActivity(new Intent(getActivity(), TasksActivity.class)));
        grades.setOnClickListener(v -> startActivity(new Intent(getActivity(), GradesActivity.class)));
        settings.setOnClickListener(v -> startActivity(new Intent(getActivity(), SettingsActivity.class)));

        return view;
    }


    public void changeToTimetable (View v){
        // Wechsel der Activity zur Stundenplan Activity
        Intent i = new Intent (getActivity(), TimetableActivity.class);
        this.getActivity().startActivity(i);
    }

    public void changeToTasks (View v){
        // Wechsel der Activity zur Aufgaben Activity
        Intent i = new Intent (this.getActivity(), TasksActivity.class);
        startActivity(i);
    }

    public void changeToGrades (View v){
        // Wechsel der Activity zur Noten Acitity
        Intent i = new Intent (this.getActivity(), GradesActivity.class);
        startActivity(i);
    }

    public void changeToSettiings (View v){
        // Wechsel der Activity zur Einsetllungs Activity
        Intent i = new Intent (this.getActivity(), SettingsActivity.class);
        startActivity(i);
    }

}
package hr.ml.plavatvornicazadatak.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.model.entity.Article;

public class StoryViewPagerFragment extends Fragment {

    private ImageView storyImage;
    private TextView storyTitle;
    private TextView storyDescription;

    private Article article;

    public StoryViewPagerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        article = bundle.getParcelable("article");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_story_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        storyImage = view.findViewById(R.id.story_image);
        storyTitle = view.findViewById(R.id.story_title);
        storyDescription = view.findViewById(R.id.story_description);

        Picasso.get().load(article.getUrlToImage()).into(storyImage);
        storyTitle.setText(article.getTitle());
        storyDescription.setText(article.getDescription());
    }

}

package com.cyberhuskies.travellersearchapp.ui.list;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cyberhuskies.travellersearchapp.R;
import com.cyberhuskies.travellersearchapp.databinding.FragmentListBinding;
import com.cyberhuskies.travellersearchapp.ui.utils.Utils;

public class UserListFragment extends Fragment {

    private FragmentListBinding binding;
    private UserListViewModel viewModel;

    public UserListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentListBinding.bind(view);
        viewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        binding.refresh.setOnRefreshListener(() -> viewModel.update());
        final UserListAdapter adapter = new UserListAdapter(id -> openProfile(id));
        binding.recycler.setAdapter(adapter);
        subscribe(viewModel, adapter);
    }

    private void subscribe(final UserListViewModel viewModel, final UserListAdapter adapter) {
        viewModel.stateLiveData.observe(getViewLifecycleOwner(), state -> {
            boolean isSuccess = !state.isLoading()
                    && state.getErrorMessage() == null
                    && state.getItems() != null;
            binding.refresh.setEnabled(!state.isLoading());
            if (!state.isLoading()) binding.refresh.setRefreshing(false);
            binding.recycler.setVisibility(Utils.visibleOrGone(isSuccess));
            binding.error.setVisibility(Utils.visibleOrGone(state.getErrorMessage() != null));
            binding.loading.setVisibility(Utils.visibleOrGone(state.isLoading()));

            binding.error.setText(state.getErrorMessage());
            if (isSuccess) {
                adapter.updateData(state.getItems());
            }
        });
    }

    private void openProfile(@NonNull String id) {
        //TODO: add code here
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}

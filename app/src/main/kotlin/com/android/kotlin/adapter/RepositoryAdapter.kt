package com.android.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.kotlin.BR
import com.android.kotlin.activity.RepositoryDetailActivity
import com.android.kotlin.databinding.RepositoryItemBinding
import com.android.kotlin.extension.format
import com.android.kotlin.extension.loadUrl
import com.android.kotlin.model.Repository
import com.ocpsoft.pretty.time.PrettyTime
import kotlinx.android.synthetic.main.repository_item.view.*

/**
 * Created by yogi.
 */
class RepositoryAdapter(val context: Context) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    var repositories: List<Repository> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return RepositoryViewHolder(RepositoryItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount(): Int = repositories.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) = holder.bind(repositories.get(position))

    fun loadRepositories(repositories: List<Repository>) {
        this.repositories = repositories
        notifyDataSetChanged()
    }

    class RepositoryViewHolder(val binding: RepositoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val context: Context = binding.root.context

        fun bind(repository: Repository) {
            binding.setVariable(BR.repo, repository)
            binding.setVariable(BR.pushedDate, PrettyTime().format(repository.pushed_at))
            itemView.repositoryItemImage.loadUrl(repository.owner.avatar_url)
            itemView.repositoryItemRootLayout.setOnClickListener { context.startActivity(RepositoryDetailActivity.getIntent(context, repository)) }
        }
    }
}
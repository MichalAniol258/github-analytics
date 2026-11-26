create table repositories (
    id BIGINT  GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    github_id BIGINT NOT NULL UNIQUE,
    owner VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    full_name VARCHAR(512) NOT NULL UNIQUE,
    description TEXT,
    primary_language VARCHAR(100),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

create table repository_snapshots (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    repository_id BIGINT NOT NULL REFERENCES repositories(id) ON DELETE CASCADE,
    stars_count INTEGER NOT NULL DEFAULT 0,
    forks_count INTEGER NOT NULL DEFAULT 0,
    open_issues_count INTEGER NOT NULL DEFAULT 0,
    watchers_count INTEGER NOT NULL DEFAULT 0,
    captured_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

create index idx_snapshots_repo_captured_at ON repository_snapshots (repository_id, captured_at DESC);
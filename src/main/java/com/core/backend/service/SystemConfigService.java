package com.core.backend.service;

import com.core.backend.entity.SystemConfig;
import com.core.backend.repository.SystemConfigRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SystemConfigService
{
	@Autowired
	private SystemConfigRepository repository;

	public SystemConfig get()
	{
		return repository.findAll().get(0);
	}

	public List<SystemConfig> getAll()
	{
		return repository.findAll();
	}

	public void save(SystemConfig systemConfig)
	{
		//FIXME SystemConfig deve ser unico por schema?.
		repository.save(systemConfig);
	}
}
